package order_history_use_case;

import org.bson.types.ObjectId;

public class OrderHistoryController {
    private final OrderHistoryInputBoundary orderHistoryInteractor;
    ObjectId currentUserId;

    public OrderHistoryController(OrderHistoryInputBoundary orderHistoryInteractor, ObjectId currentUserId) {
        this.orderHistoryInteractor = orderHistoryInteractor;
        this.currentUserId = currentUserId;
    }

    public void getOrders() {
        if(currentUserId == null){
            return;
        }

        OrderHistoryRequestModel requestModel = new OrderHistoryRequestModel(this.getCurrentUserId());

        orderHistoryInteractor.displayOrders(requestModel);
    }

    public ObjectId getCurrentUserId() {
        return currentUserId;
    }

    public OrderHistoryResponseModel getResponse(){
        return orderHistoryInteractor.getResponse(currentUserId);
    }
}
