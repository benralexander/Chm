package fam

import org.springframework.dao.DataIntegrityViolationException

class BuildCombinatorialLibraryController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [buildCombinatorialLibraryInstanceList: BuildCombinatorialLibrary.list(params), buildCombinatorialLibraryInstanceTotal: BuildCombinatorialLibrary.count()]
    }

    def create() {
        [buildCombinatorialLibraryInstance: new BuildCombinatorialLibrary(params)]
    }

    def save() {
        def buildCombinatorialLibraryInstance = new BuildCombinatorialLibrary(params)
        if (!buildCombinatorialLibraryInstance.save(flush: true)) {
            render(view: "create", model: [buildCombinatorialLibraryInstance: buildCombinatorialLibraryInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'buildCombinatorialLibrary.label', default: 'BuildCombinatorialLibrary'), buildCombinatorialLibraryInstance.id])
        redirect(action: "show", id: buildCombinatorialLibraryInstance.id)
    }

    def show() {
        def buildCombinatorialLibraryInstance = BuildCombinatorialLibrary.get(params.id)
        if (!buildCombinatorialLibraryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'buildCombinatorialLibrary.label', default: 'BuildCombinatorialLibrary'), params.id])
            redirect(action: "list")
            return
        }

        [buildCombinatorialLibraryInstance: buildCombinatorialLibraryInstance]
    }

    def edit() {
        def buildCombinatorialLibraryInstance = BuildCombinatorialLibrary.get(params.id)
        if (!buildCombinatorialLibraryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'buildCombinatorialLibrary.label', default: 'BuildCombinatorialLibrary'), params.id])
            redirect(action: "list")
            return
        }

        [buildCombinatorialLibraryInstance: buildCombinatorialLibraryInstance]
    }

    def update() {
        def buildCombinatorialLibraryInstance = BuildCombinatorialLibrary.get(params.id)
        if (!buildCombinatorialLibraryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'buildCombinatorialLibrary.label', default: 'BuildCombinatorialLibrary'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (buildCombinatorialLibraryInstance.version > version) {
                buildCombinatorialLibraryInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'buildCombinatorialLibrary.label', default: 'BuildCombinatorialLibrary')] as Object[],
                        "Another user has updated this BuildCombinatorialLibrary while you were editing")
                render(view: "edit", model: [buildCombinatorialLibraryInstance: buildCombinatorialLibraryInstance])
                return
            }
        }

        buildCombinatorialLibraryInstance.properties = params

        if (!buildCombinatorialLibraryInstance.save(flush: true)) {
            render(view: "edit", model: [buildCombinatorialLibraryInstance: buildCombinatorialLibraryInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'buildCombinatorialLibrary.label', default: 'BuildCombinatorialLibrary'), buildCombinatorialLibraryInstance.id])
        redirect(action: "show", id: buildCombinatorialLibraryInstance.id)
    }

    def delete() {
        def buildCombinatorialLibraryInstance = BuildCombinatorialLibrary.get(params.id)
        if (!buildCombinatorialLibraryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'buildCombinatorialLibrary.label', default: 'BuildCombinatorialLibrary'), params.id])
            redirect(action: "list")
            return
        }

        try {
            buildCombinatorialLibraryInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'buildCombinatorialLibrary.label', default: 'BuildCombinatorialLibrary'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'buildCombinatorialLibrary.label', default: 'BuildCombinatorialLibrary'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
