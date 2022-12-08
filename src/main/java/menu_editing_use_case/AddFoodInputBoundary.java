package menu_editing_use_case;

//Application Business Rule layer

import entities.*;
import org.bson.types.ObjectId;

public interface AddFoodInputBoundary {

    void create(AddFoodRequestModel requestModel);

    Menu getMenu();

    ObjectId getResId();


}
