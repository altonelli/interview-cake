

public class IntersectingRectangles {

    public static class Range {
        Integer start;
        Integer end;

        public Range(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }

        public Range(){}

    }

    public static class Rectangle {
        // coordinates of bottom left corner
        Integer leftX;
        Integer bottomY;

        // dimensions
        Integer width;
        Integer height;

        public Rectangle(Integer leftX, Integer bottomY, Integer width, Integer height) {
            this.leftX = leftX;
            this.bottomY = bottomY;
            this.width  = width;
            this.height = height;
        }

        public Rectangle() {}

        public String toString() {
            return String.format("(%d, %d, %d, %d)", leftX, bottomY, width, height);
        }
    }

    public static Rectangle intersectingRectangle (Rectangle rect1, Rectangle rect2) {
        Range xRange = overlapRanges(new Range(rect1.leftX, rect1.leftX + rect1.width),new Range(rect2.leftX, rect2.leftX + rect2.width));
        Range yRange = overlapRanges(new Range(rect1.bottomY, rect1.bottomY + rect1.height),new Range(rect2.bottomY, rect2.bottomY + rect2.height));
        if (xRange != null && yRange != null) {
            return new Rectangle (xRange.start, yRange.start, xRange.end - xRange.start, yRange.end - yRange.start);
        }
        return new Rectangle();
    }

    private static Range overlapRanges (Range range1, Range range2) {
        // Could refactor S.T. the highest start must but less than the lowest end
        if (( range1.start <= range2.start && range2.start <= range1.end && range1.start <= range2.end ) ||
            ( range2.start <= range1.start && range1.start <= range2.end && range2.start <= range1.end ) ) {
            return new Range (Math.max(range1.start, range2.start), Math.min(range1.end, range2.end));
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println("Should Return 3, 1, 3, 2");
        Rectangle rect1 = new Rectangle(0,0,6,3);
        Rectangle rect2 = new Rectangle(3,1,5,5);
        Rectangle output1 = intersectingRectangle (rect1,rect2);
        System.out.println (output1.toString());

        System.out.println("Should Return 0");
        Rectangle rect3 = new Rectangle(0,0,2,2);
        Rectangle rect4 = new Rectangle(2,2,4,4);
        Rectangle output2 = intersectingRectangle (rect3,rect4);
        System.out.println (output2.toString());

        System.out.println("Should Return null");
        Rectangle rect5 = new Rectangle(0,0,2,2);
        Rectangle rect6 = new Rectangle(3,3,4,4);
        Rectangle output3 = intersectingRectangle (rect5,rect6);
        System.out.println (output3.toString());
    }
}

