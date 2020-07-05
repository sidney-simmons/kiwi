// Import modules
import Vue from 'vue'
import SoftwareEngineer from './SoftwareEngineer.vue'

// Import CSS
import 'bootstrap/dist/css/bootstrap.min.css'
import '../../assets/global.css'

Vue.config.productionTip = false

new Vue({
  render: function (h) { return h(SoftwareEngineer) }
}).$mount('#app')
