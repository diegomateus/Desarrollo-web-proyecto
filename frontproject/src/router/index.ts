import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import Home from "../views/Home.vue";
import PropertyManagement from "../views/PropertyManagement.vue";
import OfferManagement from "../views/OfferManagement.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },

  {
    path: "/properties",
    name: "Property",
    component: PropertyManagement,
  },

  {
    path: "/properties/prueba/offer",
    name: "Offer",
    component: OfferManagement,
  },

  {
    path: "/about",
    name: "About",
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue"),
  },{
    path: "/template",
    name: "Template",
    component: () =>
      import(/* webpackChunkName: "template" */ "../views/Template.vue"),
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
