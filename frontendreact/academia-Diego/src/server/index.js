import { createServer, Model } from "miragejs";


import { users, collaborators } from '../mock/seeds'

export default function makeServer() {
    createServer({

    environment:  'development',
    
    models: {
        movie: Model,
    },

    routes() {
      this.namespace = "api/"

      this.get("users", () => ({
        users,
      }))

      this.get("collaborators", () => ({
        collaborators,
      }))

      this.passthrough();
    },



  });
}