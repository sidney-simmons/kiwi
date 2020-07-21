import Axios from "@/services/AxiosService";

export default new (class {
    /**
     * Get environment details from the API.
     *
     * @return the response
     */
    getEnvironment() {
        return Axios.get("/environment/get-environment").then((response) => {
            return response;
        });
    }
})();
