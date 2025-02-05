export default class ServiceBase {

    constructor(relativeBase, api = 'api/') {
        this.api = api;
        this.backendUrl = 'http://localhost:8080/' + api + relativeBase;
    }


    async create(object, commandSuffix = '') {
        return this.checkError(
            fetch(this.backendUrl + commandSuffix, {
                method: 'POST',
                cache: 'reload',
                headers: this.getJsonHeader(),
                body: JSON.stringify(object),
            }),
        );
    }

    async list(subResource = '') {
        return this.checkError(
            fetch(`${this.backendUrl}${subResource}`, {
                method: 'GET',
                cache: 'reload',
                headers: this.getJsonHeader(),
            }),
        );
    }

    async read(id, subResource = '') {
        return this.checkError(
            fetch(`${this.backendUrl}${subResource}`, {
                method: 'GET',
                cache: 'reload',
                headers: this.getJsonHeader(),
            }),
        );
    }

    async update(
        id,
        object,
        serviceName = '',
        showErrorOrWarningOnlyInDrawer = false,
    ) {
        const url = serviceName
            ? `${this.backendUrl}/${serviceName}`
            : this.backendUrl;
        return this.checkError(
            fetch(`${url}/${id}`, {
                method: 'PUT',
                cache: 'reload',
                headers: this.getJsonHeader(),
                body: JSON.stringify(object),
            }),
            showErrorOrWarningOnlyInDrawer,
        );
    }

    async delete(id, showErrorOrWarningOnlyInDrawer = false) {
        return this.checkError(
            fetch(`${this.backendUrl}/${id}`, {
                method: 'DELETE',
                cache: 'reload',
                headers: this.getJsonHeader(),
            }),
            showErrorOrWarningOnlyInDrawer,
        );
    }

    async checkError(promise, showErrorOrWarningOnlyInDrawer = false) {
        return promise.then((result) => {
            return result.json();
        });
    }


    getJsonHeader() {
        return {
            'Content-Type': 'application/json'
        };
    }

}
