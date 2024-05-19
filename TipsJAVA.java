1. List에 대한 sort

class Point{
  int x, y;
}
일 때

List<Point> point;의 y값의 오름차순으로 정렬시
points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2)
            {
              if(p1.y > p2.y)
              {
                return 1;
              }

              else if(p1.y == p2.y)
              {
                return 0;
              }

              else
              {
                return -1;
              }
            }
        });
왼쪽 값이 크다면 1, 같다면 0, 작다면 -1 반환
