import Properties from "@/properties/Properties";

export default new (class {
    /**
     * Get a property value using the given property key.
     *
     * @return the value if found, "UNKNOWN" otherwise
     */
    get(propertyKey) {
        let propertyValue = Properties[propertyKey];
        if (propertyValue) {
            return propertyValue;
        } else {
            return "UNKNOWN";
        }
    }
})();
