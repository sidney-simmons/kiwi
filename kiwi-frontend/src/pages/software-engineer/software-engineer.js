import Vue from 'vue'
import SoftwareEngineer from './SoftwareEngineer.vue'

Vue.config.productionTip = false

new Vue({
  render: function (h) { return h(SoftwareEngineer) }
}).$mount('#app')
