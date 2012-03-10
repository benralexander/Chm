package fam

import org.springframework.dao.DataIntegrityViolationException

class PrincipalMomentOfInertiaPlotController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [principalMomentOfInertiaPlotInstanceList: PrincipalMomentOfInertiaPlot.list(params), principalMomentOfInertiaPlotInstanceTotal: PrincipalMomentOfInertiaPlot.count()]
    }

    def create() {
        [principalMomentOfInertiaPlotInstance: new PrincipalMomentOfInertiaPlot(params)]
    }

    def save() {
        def principalMomentOfInertiaPlotInstance = new PrincipalMomentOfInertiaPlot(params)
        if (!principalMomentOfInertiaPlotInstance.save(flush: true)) {
            render(view: "create", model: [principalMomentOfInertiaPlotInstance: principalMomentOfInertiaPlotInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'principalMomentOfInertiaPlot.label', default: 'PrincipalMomentOfInertiaPlot'), principalMomentOfInertiaPlotInstance.id])
        redirect(action: "show", id: principalMomentOfInertiaPlotInstance.id)
    }

    def show() {
        def principalMomentOfInertiaPlotInstance = PrincipalMomentOfInertiaPlot.get(params.id)
        if (!principalMomentOfInertiaPlotInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'principalMomentOfInertiaPlot.label', default: 'PrincipalMomentOfInertiaPlot'), params.id])
            redirect(action: "list")
            return
        }

        [principalMomentOfInertiaPlotInstance: principalMomentOfInertiaPlotInstance]
    }

    def edit() {
        def principalMomentOfInertiaPlotInstance = PrincipalMomentOfInertiaPlot.get(params.id)
        if (!principalMomentOfInertiaPlotInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'principalMomentOfInertiaPlot.label', default: 'PrincipalMomentOfInertiaPlot'), params.id])
            redirect(action: "list")
            return
        }

        [principalMomentOfInertiaPlotInstance: principalMomentOfInertiaPlotInstance]
    }

    def update() {
        def principalMomentOfInertiaPlotInstance = PrincipalMomentOfInertiaPlot.get(params.id)
        if (!principalMomentOfInertiaPlotInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'principalMomentOfInertiaPlot.label', default: 'PrincipalMomentOfInertiaPlot'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (principalMomentOfInertiaPlotInstance.version > version) {
                principalMomentOfInertiaPlotInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'principalMomentOfInertiaPlot.label', default: 'PrincipalMomentOfInertiaPlot')] as Object[],
                        "Another user has updated this PrincipalMomentOfInertiaPlot while you were editing")
                render(view: "edit", model: [principalMomentOfInertiaPlotInstance: principalMomentOfInertiaPlotInstance])
                return
            }
        }

        principalMomentOfInertiaPlotInstance.properties = params

        if (!principalMomentOfInertiaPlotInstance.save(flush: true)) {
            render(view: "edit", model: [principalMomentOfInertiaPlotInstance: principalMomentOfInertiaPlotInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'principalMomentOfInertiaPlot.label', default: 'PrincipalMomentOfInertiaPlot'), principalMomentOfInertiaPlotInstance.id])
        redirect(action: "show", id: principalMomentOfInertiaPlotInstance.id)
    }

    def delete() {
        def principalMomentOfInertiaPlotInstance = PrincipalMomentOfInertiaPlot.get(params.id)
        if (!principalMomentOfInertiaPlotInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'principalMomentOfInertiaPlot.label', default: 'PrincipalMomentOfInertiaPlot'), params.id])
            redirect(action: "list")
            return
        }

        try {
            principalMomentOfInertiaPlotInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'principalMomentOfInertiaPlot.label', default: 'PrincipalMomentOfInertiaPlot'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'principalMomentOfInertiaPlot.label', default: 'PrincipalMomentOfInertiaPlot'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
