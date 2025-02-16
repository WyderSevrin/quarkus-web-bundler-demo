import {css, html, LitElement} from 'lit';
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
import CrmService from "../services/CrmService";


/**
 * This component shows the Contacts screen
 *
 */
export class ContactsView extends LitElement {
    static styles = css`
        .container > div {
            background-color: #f1f1f1;
            border: 1px solid black;
            padding: 3px;
            font-size: 1rem;
            text-align: center;
        }

        .header > div {
            font-size: 1.25rem;
            border: 2px solid black;
        }
    `;

    constructor() {
        super();
        this.crmService = new CrmService();
        this.data = [{id: 0}];
        this.initialized = false;
        this.loadData().then((response) => {
            this.data = [...response];
            this.initialized = true;
            this.requestUpdate();
        });
    }

    async loadData() {
        return await this.crmService.list('')
    }


    render() {
        if (!this.initialized) {
            return html`
                <div class='loading-reserved-zone'> Loading ...</div>`;
        }

        return html`
            <p> Here is the rendered content : </p>
            ${this.renderContent()}
        `;
    }


    renderContent() {
        return html`
            <div class="container header">
                <div> email</div>
                <div> firstname</div>
                <div> lastname</div>
            </div>
            ${this.data.map(value => this.renderRow(value))}
        `;
    }

    renderRow(value) {
        return html`
            <div class="container">
                <div>${value?.email}</div>
                <div>${value?.firstname}</div>
                <div>${value?.lastname}</div>
            </div>
        `;
    }
}

customElements.define('contacts-view', ContactsView);