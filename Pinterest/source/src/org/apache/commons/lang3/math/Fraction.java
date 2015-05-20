// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3.math;

import java.math.BigInteger;

public final class Fraction extends Number
    implements Comparable
{

    public static final Fraction FOUR_FIFTHS = new Fraction(4, 5);
    public static final Fraction ONE = new Fraction(1, 1);
    public static final Fraction ONE_FIFTH = new Fraction(1, 5);
    public static final Fraction ONE_HALF = new Fraction(1, 2);
    public static final Fraction ONE_QUARTER = new Fraction(1, 4);
    public static final Fraction ONE_THIRD = new Fraction(1, 3);
    public static final Fraction THREE_FIFTHS = new Fraction(3, 5);
    public static final Fraction THREE_QUARTERS = new Fraction(3, 4);
    public static final Fraction TWO_FIFTHS = new Fraction(2, 5);
    public static final Fraction TWO_QUARTERS = new Fraction(2, 4);
    public static final Fraction TWO_THIRDS = new Fraction(2, 3);
    public static final Fraction ZERO = new Fraction(0, 1);
    private static final long serialVersionUID = 0x3b76f0847842L;
    private final int denominator;
    private transient int hashCode;
    private final int numerator;
    private transient String toProperString;
    private transient String toString;

    private Fraction(int i, int j)
    {
        hashCode = 0;
        toString = null;
        toProperString = null;
        numerator = i;
        denominator = j;
    }

    private static int addAndCheck(int i, int j)
    {
        long l = (long)i + (long)j;
        if (l < 0xffffffff80000000L || l > 0x7fffffffL)
        {
            throw new ArithmeticException("overflow: add");
        } else
        {
            return (int)l;
        }
    }

    private Fraction addSub(Fraction fraction, boolean flag)
    {
        if (fraction == null)
        {
            throw new IllegalArgumentException("The fraction must not be null");
        }
        if (numerator == 0)
        {
            if (flag)
            {
                return fraction;
            } else
            {
                return fraction.negate();
            }
        }
        if (fraction.numerator == 0)
        {
            return this;
        }
        int k = greatestCommonDivisor(denominator, fraction.denominator);
        if (k == 1)
        {
            int i = mulAndCheck(numerator, fraction.denominator);
            k = mulAndCheck(fraction.numerator, denominator);
            if (flag)
            {
                i = addAndCheck(i, k);
            } else
            {
                i = subAndCheck(i, k);
            }
            return new Fraction(i, mulPosAndCheck(denominator, fraction.denominator));
        }
        BigInteger biginteger = BigInteger.valueOf(numerator).multiply(BigInteger.valueOf(fraction.denominator / k));
        BigInteger biginteger1 = BigInteger.valueOf(fraction.numerator).multiply(BigInteger.valueOf(denominator / k));
        int j;
        if (flag)
        {
            biginteger = biginteger.add(biginteger1);
        } else
        {
            biginteger = biginteger.subtract(biginteger1);
        }
        j = biginteger.mod(BigInteger.valueOf(k)).intValue();
        if (j == 0)
        {
            j = k;
        } else
        {
            j = greatestCommonDivisor(j, k);
        }
        biginteger = biginteger.divide(BigInteger.valueOf(j));
        if (biginteger.bitLength() > 31)
        {
            throw new ArithmeticException("overflow: numerator too large after multiply");
        } else
        {
            return new Fraction(biginteger.intValue(), mulPosAndCheck(denominator / k, fraction.denominator / j));
        }
    }

    public static Fraction getFraction(double d)
    {
        byte byte0;
        if (d < 0.0D)
        {
            byte0 = -1;
        } else
        {
            byte0 = 1;
        }
        d = Math.abs(d);
        if (d > 2147483647D || Double.isNaN(d))
        {
            throw new ArithmeticException("The value must not be greater than Integer.MAX_VALUE or NaN");
        }
        int i2 = (int)d;
        double d4 = d - (double)i2;
        int i1 = (int)d4;
        d = i1;
        double d2 = 1.7976931348623157E+308D;
        int k = 1;
        int l = 1;
        int j1 = 0;
        int j = 0;
        int i = 1;
        double d1 = 1.0D;
        d = d4 - d;
        do
        {
            double d3 = d1;
            int l1 = (int)(d3 / d);
            double d5 = l1;
            int k1 = j1 + i1 * i;
            i1 = i1 * j + l;
            d1 = Math.abs(d4 - (double)k1 / (double)i1);
            k++;
            if (d2 <= d1 || i1 > 10000 || i1 <= 0 || k >= 25)
            {
                if (k == 25)
                {
                    throw new ArithmeticException("Unable to convert double to fraction");
                } else
                {
                    return getReducedFraction(byte0 * (i2 * j + i), j);
                }
            }
            d2 = d1;
            l = j;
            d1 = d;
            j = i1;
            i1 = l1;
            d = d3 - d5 * d;
            j1 = i;
            i = k1;
        } while (true);
    }

    public static Fraction getFraction(int i, int j)
    {
        if (j == 0)
        {
            throw new ArithmeticException("The denominator must not be zero");
        }
        int l = i;
        int k = j;
        if (j < 0)
        {
            if (i == 0x80000000 || j == 0x80000000)
            {
                throw new ArithmeticException("overflow: can't negate");
            }
            l = -i;
            k = -j;
        }
        return new Fraction(l, k);
    }

    public static Fraction getFraction(int i, int j, int k)
    {
        if (k == 0)
        {
            throw new ArithmeticException("The denominator must not be zero");
        }
        if (k < 0)
        {
            throw new ArithmeticException("The denominator must not be negative");
        }
        if (j < 0)
        {
            throw new ArithmeticException("The numerator must not be negative");
        }
        long l;
        if (i < 0)
        {
            l = (long)i * (long)k - (long)j;
        } else
        {
            l = (long)i * (long)k + (long)j;
        }
        if (l < 0xffffffff80000000L || l > 0x7fffffffL)
        {
            throw new ArithmeticException("Numerator too large to represent as an Integer.");
        } else
        {
            return new Fraction((int)l, k);
        }
    }

    public static Fraction getFraction(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("The string must not be null");
        }
        if (s.indexOf('.') >= 0)
        {
            return getFraction(Double.parseDouble(s));
        }
        int k = s.indexOf(' ');
        if (k > 0)
        {
            int i = Integer.parseInt(s.substring(0, k));
            s = s.substring(k + 1);
            k = s.indexOf('/');
            if (k < 0)
            {
                throw new NumberFormatException("The fraction could not be parsed as the format X Y/Z");
            } else
            {
                return getFraction(i, Integer.parseInt(s.substring(0, k)), Integer.parseInt(s.substring(k + 1)));
            }
        }
        int j = s.indexOf('/');
        if (j < 0)
        {
            return getFraction(Integer.parseInt(s), 1);
        } else
        {
            return getFraction(Integer.parseInt(s.substring(0, j)), Integer.parseInt(s.substring(j + 1)));
        }
    }

    public static Fraction getReducedFraction(int i, int j)
    {
        if (j == 0)
        {
            throw new ArithmeticException("The denominator must not be zero");
        }
        if (i == 0)
        {
            return ZERO;
        }
        int l;
        int j1;
        if (j == 0x80000000 && (i & 1) == 0)
        {
            int k = i / 2;
            i = j / 2;
            j = k;
        } else
        {
            int i1 = i;
            i = j;
            j = i1;
        }
        j1 = i;
        l = j;
        if (i < 0)
        {
            if (j == 0x80000000 || i == 0x80000000)
            {
                throw new ArithmeticException("overflow: can't negate");
            }
            l = -j;
            j1 = -i;
        }
        i = greatestCommonDivisor(l, j1);
        return new Fraction(l / i, j1 / i);
    }

    private static int greatestCommonDivisor(int i, int j)
    {
        if (i == 0 || j == 0)
        {
            if (i == 0x80000000 || j == 0x80000000)
            {
                throw new ArithmeticException("overflow: gcd is 2^31");
            } else
            {
                return Math.abs(i) + Math.abs(j);
            }
        }
        if (Math.abs(i) == 1 || Math.abs(j) == 1)
        {
            return 1;
        }
        if (i > 0)
        {
            i = -i;
        }
        int k = j;
        if (j > 0)
        {
            k = -j;
        }
        int l = 0;
        j = i;
        for (i = k; (j & 1) == 0 && (i & 1) == 0 && l < 31; l++)
        {
            j /= 2;
            i /= 2;
        }

        if (l == 31)
        {
            throw new ArithmeticException("overflow: gcd is 2^31");
        }
        if ((j & 1) == 1)
        {
            k = i;
        } else
        {
            int i1 = -(j / 2);
            k = i;
            i = i1;
        }
        do
        {
            for (; (i & 1) == 0; i /= 2) { }
            int j1;
            int k1;
            if (i > 0)
            {
                j1 = -i;
            } else
            {
                k = i;
                j1 = j;
            }
            k1 = (k - j1) / 2;
            i = k1;
            j = j1;
        } while (k1 != 0);
        return -j1 * (1 << l);
    }

    private static int mulAndCheck(int i, int j)
    {
        long l = (long)i * (long)j;
        if (l < 0xffffffff80000000L || l > 0x7fffffffL)
        {
            throw new ArithmeticException("overflow: mul");
        } else
        {
            return (int)l;
        }
    }

    private static int mulPosAndCheck(int i, int j)
    {
        long l = (long)i * (long)j;
        if (l > 0x7fffffffL)
        {
            throw new ArithmeticException("overflow: mulPos");
        } else
        {
            return (int)l;
        }
    }

    private static int subAndCheck(int i, int j)
    {
        long l = (long)i - (long)j;
        if (l < 0xffffffff80000000L || l > 0x7fffffffL)
        {
            throw new ArithmeticException("overflow: add");
        } else
        {
            return (int)l;
        }
    }

    public final Fraction abs()
    {
        if (numerator >= 0)
        {
            return this;
        } else
        {
            return negate();
        }
    }

    public final Fraction add(Fraction fraction)
    {
        return addSub(fraction, true);
    }

    public final volatile int compareTo(Object obj)
    {
        return compareTo((Fraction)obj);
    }

    public final int compareTo(Fraction fraction)
    {
        if (this != fraction && (numerator != fraction.numerator || denominator != fraction.denominator))
        {
            long l = (long)numerator * (long)fraction.denominator;
            long l1 = (long)fraction.numerator * (long)denominator;
            if (l != l1)
            {
                return l >= l1 ? 1 : -1;
            }
        }
        return 0;
    }

    public final Fraction divideBy(Fraction fraction)
    {
        if (fraction == null)
        {
            throw new IllegalArgumentException("The fraction must not be null");
        }
        if (fraction.numerator == 0)
        {
            throw new ArithmeticException("The fraction to divide by must not be zero");
        } else
        {
            return multiplyBy(fraction.invert());
        }
    }

    public final double doubleValue()
    {
        return (double)numerator / (double)denominator;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof Fraction))
            {
                return false;
            }
            obj = (Fraction)obj;
            if (getNumerator() != ((Fraction) (obj)).getNumerator() || getDenominator() != ((Fraction) (obj)).getDenominator())
            {
                return false;
            }
        }
        return true;
    }

    public final float floatValue()
    {
        return (float)numerator / (float)denominator;
    }

    public final int getDenominator()
    {
        return denominator;
    }

    public final int getNumerator()
    {
        return numerator;
    }

    public final int getProperNumerator()
    {
        return Math.abs(numerator % denominator);
    }

    public final int getProperWhole()
    {
        return numerator / denominator;
    }

    public final int hashCode()
    {
        if (hashCode == 0)
        {
            hashCode = (getNumerator() + 629) * 37 + getDenominator();
        }
        return hashCode;
    }

    public final int intValue()
    {
        return numerator / denominator;
    }

    public final Fraction invert()
    {
        if (numerator == 0)
        {
            throw new ArithmeticException("Unable to invert zero.");
        }
        if (numerator == 0x80000000)
        {
            throw new ArithmeticException("overflow: can't negate numerator");
        }
        if (numerator < 0)
        {
            return new Fraction(-denominator, -numerator);
        } else
        {
            return new Fraction(denominator, numerator);
        }
    }

    public final long longValue()
    {
        return (long)numerator / (long)denominator;
    }

    public final Fraction multiplyBy(Fraction fraction)
    {
        if (fraction == null)
        {
            throw new IllegalArgumentException("The fraction must not be null");
        }
        if (numerator == 0 || fraction.numerator == 0)
        {
            return ZERO;
        } else
        {
            int i = greatestCommonDivisor(numerator, fraction.denominator);
            int j = greatestCommonDivisor(fraction.numerator, denominator);
            return getReducedFraction(mulAndCheck(numerator / i, fraction.numerator / j), mulPosAndCheck(denominator / j, fraction.denominator / i));
        }
    }

    public final Fraction negate()
    {
        if (numerator == 0x80000000)
        {
            throw new ArithmeticException("overflow: too large to negate");
        } else
        {
            return new Fraction(-numerator, denominator);
        }
    }

    public final Fraction pow(int i)
    {
        Fraction fraction = this;
        do
        {
            if (i == 1)
            {
                return fraction;
            }
            if (i == 0)
            {
                return ONE;
            }
            if (i < 0)
            {
                if (i == 0x80000000)
                {
                    fraction = fraction.invert().pow(2);
                    i = -(i / 2);
                } else
                {
                    fraction = fraction.invert();
                    i = -i;
                }
            } else
            {
                Fraction fraction1 = fraction.multiplyBy(fraction);
                if (i % 2 == 0)
                {
                    i /= 2;
                    fraction = fraction1;
                } else
                {
                    return fraction1.pow(i / 2).multiplyBy(fraction);
                }
            }
        } while (true);
    }

    public final Fraction reduce()
    {
        if (numerator != 0) goto _L2; else goto _L1
_L1:
        if (!equals(ZERO)) goto _L4; else goto _L3
_L3:
        return this;
_L4:
        return ZERO;
_L2:
        int i = greatestCommonDivisor(Math.abs(numerator), denominator);
        if (i != 1)
        {
            return getFraction(numerator / i, denominator / i);
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public final Fraction subtract(Fraction fraction)
    {
        return addSub(fraction, false);
    }

    public final String toProperString()
    {
        if (toProperString == null)
        {
            if (numerator == 0)
            {
                toProperString = "0";
            } else
            if (numerator == denominator)
            {
                toProperString = "1";
            } else
            if (numerator == denominator * -1)
            {
                toProperString = "-1";
            } else
            {
                int i;
                if (numerator > 0)
                {
                    i = -numerator;
                } else
                {
                    i = numerator;
                }
                if (i < -denominator)
                {
                    i = getProperNumerator();
                    if (i == 0)
                    {
                        toProperString = Integer.toString(getProperWhole());
                    } else
                    {
                        toProperString = (new StringBuilder(32)).append(getProperWhole()).append(' ').append(i).append('/').append(getDenominator()).toString();
                    }
                } else
                {
                    toProperString = (new StringBuilder(32)).append(getNumerator()).append('/').append(getDenominator()).toString();
                }
            }
        }
        return toProperString;
    }

    public final String toString()
    {
        if (toString == null)
        {
            toString = (new StringBuilder(32)).append(getNumerator()).append('/').append(getDenominator()).toString();
        }
        return toString;
    }

}
