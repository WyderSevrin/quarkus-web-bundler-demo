import { LitElement, html, css} from 'lit';
import { customElement, state } from 'lit/decorators.js';
import { unsafeHTML } from 'lit/directives/unsafe-html.js';
import '@vaadin/form-layout';
import '@vaadin/text-field';
import '@vaadin/combo-box';
import '@vaadin/radio-group';
import '@vaadin/button';
import '@vaadin/tabs';
import '@vaadin/tabsheet';
import '@vaadin/icon';
import '@vaadin/vaadin-lumo-styles/vaadin-iconset';
import '@vaadin/icons';
import '@vaadin/progress-bar';
import '@vaadin/tabs';
import '@vaadin/tabsheet';


/**
 * This component shows the Home screen
 *
 */
class HomeView extends LitElement {
    static styles = css`p { color: blue }`;


    constructor() {
        super();
    }

    render() {
        return html`
           <p>Home view !</p>
        `;
    }


}

customElements.define('home-view', HomeView);