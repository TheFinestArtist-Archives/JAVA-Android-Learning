// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;

import io.realm.exceptions.RealmIOException;
import java.io.Closeable;
import java.io.IOError;

// Referenced classes of package io.realm.internal:
//            TightDB, Context, ImplicitTransaction, ReadTransaction, 
//            Group, WriteTransaction

public class SharedGroup
    implements Closeable
{

    private boolean activeTransaction;
    private final Context context;
    private boolean implicitTransactionsEnabled;
    private long nativePtr;
    private long nativeReplicationPtr;

    public SharedGroup(String s)
    {
        implicitTransactionsEnabled = false;
        context = new Context();
        nativePtr = nativeCreate(s, Durability.FULL.value, false, false, null);
        checkNativePtrNotZero();
    }

    public SharedGroup(String s, Durability durability, boolean flag)
    {
        implicitTransactionsEnabled = false;
        context = new Context();
        nativePtr = nativeCreate(s, durability.value, flag, false, null);
        checkNativePtrNotZero();
    }

    public SharedGroup(String s, Durability durability, byte abyte0[])
    {
        implicitTransactionsEnabled = false;
        context = new Context();
        nativePtr = nativeCreate(s, durability.value, false, false, abyte0);
        checkNativePtrNotZero();
    }

    public SharedGroup(String s, boolean flag, byte abyte0[])
    {
        implicitTransactionsEnabled = false;
        if (flag)
        {
            nativeReplicationPtr = nativeCreateReplication(s, abyte0);
            nativePtr = createNativeWithImplicitTransactions(nativeReplicationPtr, abyte0);
            implicitTransactionsEnabled = true;
        } else
        {
            nativePtr = nativeCreate(s, Durability.FULL.value, false, false, abyte0);
        }
        context = new Context();
        checkNativePtrNotZero();
    }

    private void checkNativePtrNotZero()
    {
        if (nativePtr == 0L)
        {
            throw new IOError(new RealmIOException("Realm could not be opened"));
        } else
        {
            return;
        }
    }

    private native long createNativeWithImplicitTransactions(long l, byte abyte0[]);

    private native void nativeAdvanceRead(long l);

    private native long nativeBeginImplicit(long l);

    private native long nativeBeginRead(long l);

    private native long nativeBeginWrite(long l);

    protected static native void nativeClose(long l);

    private native void nativeCloseReplication(long l);

    private native void nativeCommit(long l);

    private native void nativeCommitAndContinueAsRead(long l);

    private native long nativeCreate(String s, int i, boolean flag, boolean flag1, byte abyte0[]);

    private native long nativeCreateReplication(String s, byte abyte0[]);

    private native void nativeEndRead(long l);

    static native String nativeGetDefaultReplicationDatabaseFileName();

    private native boolean nativeHasChanged(long l);

    private native void nativePromoteToWrite(long l);

    private native void nativeReserve(long l, long l1);

    private native void nativeRollback(long l);

    private native void nativeRollbackAndContinueAsRead(long l);

    void advanceRead()
    {
        nativeAdvanceRead(nativePtr);
    }

    public ImplicitTransaction beginImplicitTransaction()
    {
        if (activeTransaction)
        {
            throw new IllegalStateException("Can't beginImplicitTransaction() during another active transaction");
        } else
        {
            long l = nativeBeginImplicit(nativePtr);
            ImplicitTransaction implicittransaction = new ImplicitTransaction(context, this, l);
            activeTransaction = true;
            return implicittransaction;
        }
    }

    public ReadTransaction beginRead()
    {
        if (activeTransaction)
        {
            throw new IllegalStateException("Can't beginRead() during another active transaction");
        }
        long l = nativeBeginRead(nativePtr);
        ReadTransaction readtransaction;
        try
        {
            readtransaction = new ReadTransaction(context, this, l);
            activeTransaction = true;
        }
        catch (RuntimeException runtimeexception)
        {
            Group.nativeClose(l);
            throw runtimeexception;
        }
        return readtransaction;
    }

    public WriteTransaction beginWrite()
    {
        if (activeTransaction)
        {
            throw new IllegalStateException("Can't beginWrite() during another active transaction");
        }
        long l = nativeBeginWrite(nativePtr);
        WriteTransaction writetransaction;
        try
        {
            writetransaction = new WriteTransaction(context, this, l);
            activeTransaction = true;
        }
        catch (RuntimeException runtimeexception)
        {
            Group.nativeClose(l);
            throw runtimeexception;
        }
        return writetransaction;
    }

    public void close()
    {
        synchronized (context)
        {
            if (nativePtr != 0L)
            {
                nativeClose(nativePtr);
                nativePtr = 0L;
                if (implicitTransactionsEnabled && nativeReplicationPtr != 0L)
                {
                    nativeCloseReplication(nativeReplicationPtr);
                    nativeReplicationPtr = 0L;
                }
            }
        }
        return;
        exception;
        context1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void commit()
    {
        if (isClosed())
        {
            throw new IllegalStateException("Can't commit() on closed group. WriteTransaction is invalid.");
        } else
        {
            nativeCommit(nativePtr);
            activeTransaction = false;
            return;
        }
    }

    void commitAndContinueAsRead()
    {
        nativeCommitAndContinueAsRead(nativePtr);
    }

    void endRead()
    {
        if (isClosed())
        {
            throw new IllegalStateException("Can't endRead() on closed group. ReadTransaction is invalid.");
        } else
        {
            nativeEndRead(nativePtr);
            activeTransaction = false;
            return;
        }
    }

    protected void finalize()
    {
        synchronized (context)
        {
            if (nativePtr != 0L)
            {
                context.asyncDisposeSharedGroup(nativePtr);
                nativePtr = 0L;
                if (implicitTransactionsEnabled && nativeReplicationPtr != 0L)
                {
                    nativeCloseReplication(nativeReplicationPtr);
                    nativeReplicationPtr = 0L;
                }
            }
        }
        return;
        exception;
        context1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean hasChanged()
    {
        return nativeHasChanged(nativePtr);
    }

    boolean isClosed()
    {
        return nativePtr == 0L;
    }

    void promoteToWrite()
    {
        nativePromoteToWrite(nativePtr);
    }

    public void reserve(long l)
    {
        nativeReserve(nativePtr, l);
    }

    void rollback()
    {
        if (isClosed())
        {
            throw new IllegalStateException("Can't rollback() on closed group. WriteTransaction is invalid.");
        } else
        {
            nativeRollback(nativePtr);
            activeTransaction = false;
            return;
        }
    }

    void rollbackAndContinueAsRead()
    {
        nativeRollbackAndContinueAsRead(nativePtr);
    }

    static 
    {
        TightDB.loadLibrary();
    }

    private class Durability extends Enum
    {

        private static final Durability $VALUES[];
        public static final Durability FULL;
        public static final Durability MEM_ONLY;
        final int value;

        public static Durability valueOf(String s)
        {
            return (Durability)Enum.valueOf(io/realm/internal/SharedGroup$Durability, s);
        }

        public static Durability[] values()
        {
            return (Durability[])$VALUES.clone();
        }

        static 
        {
            FULL = new Durability("FULL", 0, 0);
            MEM_ONLY = new Durability("MEM_ONLY", 1, 1);
            $VALUES = (new Durability[] {
                FULL, MEM_ONLY
            });
        }

        private Durability(String s, int i, int j)
        {
            super(s, i);
            value = j;
        }
    }

}
