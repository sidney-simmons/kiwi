import Axios from "axios";

export default new (class {
    /**
     * Get a list of repositories from the API.
     *
     * @return the response
     */
    getRepositories() {
        return Axios.get("/software-engineer/get-repositories").then((response) => {
            return response;
        });
    }
})();
