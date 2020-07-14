import Properties from "@/properties/Properties.js";
import Axios from "axios";

export default new (class {
    get(propertyKey) {
        let propertyValue = Properties[propertyKey];
        if (propertyValue) {
            return propertyValue;
        } else {
            return "UNKNOWN";
        }
    }
})();
