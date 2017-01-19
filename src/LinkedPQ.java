

public class LinkedPQ {

	private int size;
	private PQNode head;
	private PQNodeRAM head1;

	/* tail is of no use here. */
	public LinkedPQ() {
		head = null;
		size = 0;
	}

	public int length() {
		return size;
	}

	public boolean full() {
		return false;
	}

	public void enqueueTOSSD(Program e, double Program_SizePRI) {
		PQNode tmp = new PQNode(e, Program_SizePRI);
		if ((size == 0) || (Program_SizePRI < head.Program_SizePRI)) {
			tmp.next = head;
			head = tmp;
		} else {

			PQNode p = head;
			PQNode q = null;
			while ((p != null) && (Program_SizePRI >= p.Program_SizePRI)) {
				q = p;
				p = p.next;
			}
			tmp.next = p;
			q.next = tmp;
		}
		size++;
	}
	
	public void enqueueTORAM(Program e, double Exepected_Execution_time) {
		PQNodeRAM tmp = new PQNodeRAM(e, Exepected_Execution_time);
		if ((size == 0) || (Exepected_Execution_time < head1.Exepected_Execution_time)) {
			tmp.next = head1;
			head1 = tmp;
		} else {

			PQNodeRAM p = head1;
			PQNodeRAM q = null;
			while ((p != null) && (Exepected_Execution_time >= p.Exepected_Execution_time)) {
				q = p;
				p = p.next;
			}
			tmp.next = p;
			q.next = tmp;
		}
		size++;
	}
	

	public PQNode serve() {
		PQNode node = head;
		head = head.next;
		size--;
		return node;
	}
	
	public PQNodeRAM serveRAM() {
		PQNodeRAM Node = head1;
		if(head1.next != null)
		head1 = head1.next;
		size--;
		return Node;
	}

	
		}
	

