//Find the K closest points to the origin(0,0) in a 2D plane, given an array containing N points.
/*
public class Point {
    public int x;
    public int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
*/

	public List<Point> findKClosest(Point[] p, int k) {

		List<Point> list = new ArrayList<>();

		if (p == null || p.length == 0) {
			return list;
		}

		PriorityQueue<Point> q =
			new PriorityQueue<>((o1, o2) -> (o2.y * o2.y + o2.y * o2.x) - (o1.y * o1.y + o1.y * o1.x));

		int i = 0;

		for (Point curr : p) {

			if (i < k) {
				q.add(curr);
			} else {

				Point temp = q.peek();

				if ((curr.x * curr.x + curr.y * curr.y) - (temp.x * temp.x + temp.y * temp.y) < 0) {
					q.poll();
					q.add(curr);
				}

			}

		}
		
		for(Point point : q){
			list.add(point);
		}
		
		return list;


	}




public List<Point> findKClosest(Point[] p, int k) {
	//initial capacity and comparator
	PriorityQueue<Point> pq = new PriorityQueue<Point>(10, new Comparator<Point>(){
		@Override
		public int compare(Point a, Point b){
			//升序排列
			return (b.x*b.x+b.y*b.y)-(a.x*a.x+a.y*a.y);
		}
	});
	//maintain k smallest Point in the PriorityQueue
	for(int i=0;i<p.length;i++){
		if(i<k){
			pq.off(p[i]);
		}else{
			Point temp = pq.peak();
			if((p[i].x*p[i].x+p[i].y*p[i].y)-(temp.x*temp.x+temp.y*temp.y) < 0){
				pq.poll();
				pq.offer(p[i]);
			}
		}
	}
	List<Point> resultLst = new ArrayList<Point>();
	while(!pq.isEmpty()){
		resultLst.add(pq.poll());
	}
	return resultLst;
}
