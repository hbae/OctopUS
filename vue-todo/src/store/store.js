import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex); //vue플러그인, 글로벌functionality추가

export const store = new Vuex.store({
    state: {
        headerText: 'TODO it!',
    }
});