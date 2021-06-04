import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import Home from "../views/Home.vue";
import PropertyManagement from "../views/PropertyManagement.vue";
import OfferManagement from "../views/OfferManagement.vue";

import Employees from "@/views/Employees.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "Home",
    component: Home,
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
  },

  {
    path: "/employees",
    name: "Employees",
    component: Employees,
  },

  {
    path: "/appointments",
    name: "Appointments",
    component: () =>
      import(/* webpackChunkName: "template" */ "../views/Appointments.vue"),
  },
  {
    path: "/login",
    name: "Login",
    component: () =>
      import(/* webpackChunkName: "template" */ "../views/Login.vue"),
  },
  {
    path: "/properties",
    name: "Properties",
    component: () =>
      import(/* webpackChunkName: "template" */ "../views/Properties.vue"),
  },
  {
    path: "/properties/:id",
    name: "PropertyPage",
    component: () =>
      import(/* webpackChunkName: "template" */ "../views/PropertyPage.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
