/**
 * This Queue maintains the queue of messages coming from connected clients.
 */
public class P2PMessageQueue {

    private P2PMessage head = null;
    private P2PMessage tail = null;


    /**
     * This method allows adding a message object to the existing queue.
     * @param oMessage
     */
    public synchronized void enqueue(P2PMessage oMessage){

        if(!hasNodes()) {
            head = oMessage;
            return;
        }
        else {
            head = new P2PMessage();
            tail = head;
        }
        tail = oMessage;
    }


    /**
     * This method allows removing a message object from the existing queue.
     * @return
     */
    public synchronized P2PMessage dequeue(){

        P2PMessage temp = new P2PMessage();

        if(!hasNodes()) {

            System.out.println("No messages in queue.");
        }

        temp = head;
        if(tail == head) {

            tail = null;
        }


        head = head.next;
        return temp;


    }


    public boolean hasNodes(){

        boolean checkNode = true;
        if(tail != null ) {
            checkNode = false;
        }
        else if(head != null){
            checkNode = false;
        }
        return checkNode;


    }
}

