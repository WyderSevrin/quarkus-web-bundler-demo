import {LitElement, html, css} from 'lit';
import {customElement, state} from 'lit/decorators.js';

import {Router} from '@vaadin/router';

import '../views/homeView.js';
import '../views/docView.js';


const router = new Router(document.getElementById('outlet'));
router.setRoutes([
{path: '/', component: 'home-view', name: 'Browse'},
{path: '/doc', component: 'doc-view', name: 'Getting Started'},
]);

export class Navigation extends LitElement {

  static get properties() {
    return {
      location: { type: Object }
    };
  }



  constructor() {
    super();
    this.location = router.location;

    router.ready.then(() => {
      this.location = router.location;
      this.requestUpdate(); // Ensure UI updates when router is ready
    });
  }

  render() {
    const routes = router.getRoutes();
    return html`
      <vaadin-tabs .selected=${undefined}>
        ${routes.map((r) => {
          let ignore = r.path.includes(":");
          if (!ignore) {
            const selected = this.isCurrentLocation(r);
            return html`
              <vaadin-tab .selected=${selected}>
                <a href="${r.path}">
                  <span>${r.name}</span>
                </a>
              </vaadin-tab>`;
          }
        })}
      </vaadin-tabs>`;
  }

  isCurrentLocation(route) {
    return router.urlForPath(route.path) === this.location.getUrl();
  }
}

customElements.define('app-nav', Navigation);