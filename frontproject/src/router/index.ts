import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import Home from "../views/Home.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "Home",
    component: Home,
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
    path: "/appointments",
    name: "Appointments",
    component: () =>
      import(/* webpackChunkName: "template" */ "../views/Appointments.vue"),
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
