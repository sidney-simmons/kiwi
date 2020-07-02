import Vue from 'vue'
import About from './About.vue'
import store from '../../store'

Vue.config.productionTip = false

new Vue({
  store,
  render: function (h) { return h(About) }
}).$mount('#app')
