// Import modules
import Vue from 'vue'
import Contact from './Contact.vue'

// Import CSS
import 'bootstrap/dist/css/bootstrap.min.css'
import '../../assets/global.css'

// Import javascript
import 'jquery/dist/jquery.min.js'
import 'popper.js/dist/popper.min.js'
import 'bootstrap/dist/js/bootstrap.min.js'

Vue.config.productionTip = false

new Vue({
  render: function (h) { return h(Contact) }
}).$mount('#app')
