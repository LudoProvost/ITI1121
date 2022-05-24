public class Combination {
    int first;
    int second;
    int third;

    public Combination( int first, int second, int third ) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public boolean equals(Combination other) {
        if (this == other) return true;
        if (other == null) return false;
        return first == other.first && second == other.second && third == other.third;
    }

    public String toString() {
        return (this.first + ":" + this.second + ":" + this.third);
    }

    public static void main(String[] args) {
        Combination c1, c2, c3;
        c1 = new Combination(1, 2, 3);
        c2 = new Combination(1, 2, 3);
        c3 = new Combination(3, 2, 1);
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));
        System.out.println(c1);
    }
}