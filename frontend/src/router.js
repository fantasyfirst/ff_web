import Vue from "vue";
import Router from "vue-router";
import Dashboard from "./views/Dashboard.vue";
import Draft from "./views/Draft.vue";
import Scores from "./views/Scores.vue";

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/",
      name: "dashboard",
      component: Dashboard
    },
    {
      path: "/draft",
      name: "draft",
      component: Draft
    },
    {
      path: "/scores",
      name: "scores",
      component: Scores
    }
  ]
});
