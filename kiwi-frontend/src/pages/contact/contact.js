import Vue from 'vue'
import Contact from './Contact.vue'

Vue.config.productionTip = false

new Vue({
  render: function (h) { return h(Contact) }
}).$mount('#app')
