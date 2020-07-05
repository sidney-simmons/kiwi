// Import modules
import Vue from 'vue'
import Contact from './Contact.vue'

// Import CSS
import 'bootstrap/dist/css/bootstrap.min.css'
import '../../assets/global.css'

Vue.config.productionTip = false

new Vue({
  render: function (h) { return h(Contact) }
}).$mount('#app')
