class Solution {
    class Point {
        int a, b;
        Point(int a, int b) {
            this.a = a;
            this.b = b;
        }

        
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return p.a == a && p.b == b;
        }

        
        public int hashCode() {
            return 31 * a + b;
        }
    }
    public int minAreaRect(int[][] points) {
        Set<Point> pointSet = new HashSet<>();

        int size = Integer.MAX_VALUE;

        for (int[] point : points) {
            int x1 = point[0], y1 = point[1];
            for (Point p : pointSet) {
                int x2 = p.a, y2 = p.b;
                if (x1 != x2 && y1 != y2 && pointSet.contains(new Point(x2, y1)) && pointSet.contains(new Point(x1, y2))) {
                    size = Math.min(size, Math.abs(x2 - x1) * Math.abs(y2 - y1));
                }
            }
            pointSet.add(new Point(x1, y1));
        }

        return (size == Integer.MAX_VALUE ? 0 : size);
    }
}