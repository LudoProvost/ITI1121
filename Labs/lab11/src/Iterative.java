public class Iterative {

    public static BitList complement(BitList in) {
        String s = "";

        while (in.iterator().hasNext()) {
            int temp = in.iterator().next();
            if (temp == BitList.ONE) {
                s += BitList.ZERO;
            } else if (temp == BitList.ZERO) {
                s += BitList.ONE;
            } else {
                throw new IllegalArgumentException();
            }

            in.removeFirst();
        }

        return new BitList(new StringBuilder(s).reverse().toString());

    }

    public static BitList or(BitList a, BitList b) {
        String s = "";
        if (!a.iterator().hasNext() || !b.iterator().hasNext()) {
            throw new IllegalArgumentException(s);
        }

        while (a.iterator().hasNext() && b.iterator().hasNext()) {

            int tempA = a.iterator().next();
            int tempB = b.iterator().next();
            int sum = tempA + tempB;

            if (sum >= BitList.ONE) {
                s += BitList.ONE;
            } else if (sum == BitList.ZERO) {
                s += BitList.ZERO;
            } else {
                throw new IllegalArgumentException();
            }

            a.removeFirst();
            b.removeFirst();

        }

        if ((!a.iterator().hasNext() && b.iterator().hasNext())
                || (a.iterator().hasNext() && !b.iterator().hasNext())) {
            throw new IllegalArgumentException(s);
        }

        return new BitList(new StringBuilder(s).reverse().toString());

    }

    public static BitList and(BitList a, BitList b) {
        String s = "";
        if (!a.iterator().hasNext() || !b.iterator().hasNext()) {
            throw new IllegalArgumentException(s);
        }

        while (a.iterator().hasNext() && b.iterator().hasNext()) {


            int tempA = a.iterator().next();
            int tempB = b.iterator().next();
            int sum = tempA + tempB;

            if (sum == 2 * BitList.ONE) {
                s += BitList.ONE;
            } else if (sum <= BitList.ONE) {
                s += BitList.ZERO;
            } else {
                throw new IllegalArgumentException(s);
            }

            a.removeFirst();
            b.removeFirst();
        }

        if ((!a.iterator().hasNext() && b.iterator().hasNext())
                || (a.iterator().hasNext() && !b.iterator().hasNext())) {
            throw new IllegalArgumentException(s);
        }

        return new BitList(new StringBuilder(s).reverse().toString());
    }

    public static BitList xor(BitList a, BitList b) {
        String s = "";
        if (!a.iterator().hasNext() || !b.iterator().hasNext()) {
            throw new IllegalArgumentException(s);
        }

        while (a.iterator().hasNext() && b.iterator().hasNext()) {
            int tempA = a.iterator().next();
            int tempB = b.iterator().next();
            int sum = tempA + tempB;

            if (sum == BitList.ONE) {
                s += BitList.ONE;
            } else if (sum == 2 * BitList.ONE || sum == BitList.ZERO) {
                s += BitList.ZERO;
            } else {
                throw new IllegalArgumentException(s);
            }

            a.removeFirst();
            b.removeFirst();
        }

        if ((!a.iterator().hasNext() && b.iterator().hasNext())
                || (a.iterator().hasNext() && !b.iterator().hasNext())) {
            throw new IllegalArgumentException(s);
        }

        return new BitList(new StringBuilder(s).reverse().toString());
    }
}