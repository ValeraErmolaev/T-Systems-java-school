

// let my_carousel = Vue.component("carousel", {
//   template: "#v-carousel",
//   data() {
// // this.items.add( {name: "Test from push",tag: []});
//     return {
//       currentOffset: 0,
//       windowSize: 3,
//       paginationFactor: 220,
//       items: [
//         {name: 'myMap.get(1)', tag: ["cool tariff"]},
//         {name: 'myMap.get(1)', tag: ["cool tariff"]},
//         {name: 'myMap.get(1)', tag: ["cool tariff"]},
//         {name: 2345, tag: ["cool tariff"]},
//         {name: 'Tariff 5', tag: ["cool tariff"]},
//         {name: 'Tariff 6', tag: ["cool tariff"]},
//         {name: 'Tariff 7', tag: ["cool tariff"]},
//       ]
//
//
//     }
//
//   },
//
//   computed: {
//     atEndOfList() {
//       return this.currentOffset <= (this.paginationFactor * -1) * (this.items.length - this.windowSize);
//     },
//     atHeadOfList() {
//       return this.currentOffset === 0;
//     },
//   },
//   methods: {
//     moveCarousel(direction) {
//       // Find a more elegant way to express the :style. consider using props to make it truly generic
//       if (direction === 1 && !this.atEndOfList) {
//         this.currentOffset -= this.paginationFactor;
//       } else if (direction === -1 && !this.atHeadOfList) {
//         this.currentOffset += this.paginationFactor;
//       }
//     },
//   }
// });
let my_carousel = Vue.component("carousel", {
  template: "#v-carousel",
  data: {
     items: []
          },

  computed: {
    atEndOfList() {
      return this.currentOffset <= (this.paginationFactor * -1) * (this.items.length - this.windowSize);
    },
    atHeadOfList() {
      return this.currentOffset === 0;
    },
  },
  methods: {
    moveCarousel(direction) {
      // Find a more elegant way to express the :style. consider using props to make it truly generic
      if (direction === 1 && !this.atEndOfList) {
        this.currentOffset -= this.paginationFactor;
      } else if (direction === -1 && !this.atHeadOfList) {
        this.currentOffset += this.paginationFactor;
      }
    },
  }
});
my_carousel.items.push({name: "test", tag:["test_tag"]})
new Vue({
  el:"#app"
});
