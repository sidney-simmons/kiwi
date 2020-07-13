// Import modules
import Vue from "vue";
import SoftwareEngineer from "./SoftwareEngineer.vue";

// Import CSS
import "bootstrap/dist/css/bootstrap.min.css";
import "@/assets/css/global.css";

// Import javascript
import "jquery/dist/jquery.min.js";
import "popper.js/dist/popper.min.js";
import "bootstrap/dist/js/bootstrap.min.js";

Vue.config.productionTip = false;

new Vue({
    render: function (h) {
        return h(SoftwareEngineer);
    },
}).$mount("#app");
