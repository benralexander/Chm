package fam

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.web.multipart.MultipartHttpServletRequest
import org.springframework.web.context.request.RequestContextHolder
import grails.plugins.springsecurity.Secured
import chm.sec.TbRole
import chm.sec.TbUser
import chm.sec.TbUserTbRole;

class OpticalStructureRecognitionController {
    def springSecurityService

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }


    def createNewLogin() {
        chm.sec.TbUser tbUser = new chm.sec.TbUser(
                username: params.username,
                password: params.password,
                enabled: true)
        if (tbUser.validate()) {
            tbUser.save(flush: true)
            TbUserTbRole.create tbUser, TbRole.findByAuthority("ROLE_USER"), true
        }  else {
            println("problems!")
        }

    }


//    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def list() {
        // We are ready to display somebody's molecule,  but wwe could get here with the log in, in which case we want to
        //  ask the user to login (though we will let them read the page even without this log in)
        String username  = "anonymous"
        int firstTime = 0
        String result
        if (somebodyIsLoggedIn()) {
            // We recognize this person
            firstTime = 1
            username  = currentUser()
            String nameOfTemporaryFile = "\\temp\\dnld${username}.png"

            //Use Osra only if the user  has a PNG for us
            if ((new File(nameOfTemporaryFile)).exists()) {
                result = "cmd /c osra.bat ${nameOfTemporaryFile}".execute().text
            } else {
                result = ""
            }

        } else {
            result = ""
        }
        [chmHolderInstanceList: OpticalStructureRecognition.list(params), chmHolderInstanceTotal: OpticalStructureRecognition.count(), foo: "${result.trim()}", werenew: firstTime,username: username]
    }


    def create() {
        [chmHolderInstance: new OpticalStructureRecognition(params)]
    }

    def save() {
        def chmHolderInstance = new OpticalStructureRecognition(params)
        if (!chmHolderInstance.save(flush: true)) {
            render(view: "create", model: [chmHolderInstance: chmHolderInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'chmHolder.label', default: 'OpticalStructureRecognition'), chmHolderInstance.id])
        redirect(action: "show", id: chmHolderInstance.id)
    }

    def show() {

        OutputStream out = response.getOutputStream()
        String smilesString  = params.osraStructure
        response.setContentLength(smilesString.size())
        response.addHeader("Content-disposition", "attachment; filename=molecule.smi")
        response.addHeader("Content-type", "chemical/x-daylight-smiles")
        out.write(smilesString.getBytes())
        response.outputStream.flush()
        out.close()
        // we're done rendering, and the old page has everything we want for the screen.  Inform Grails of these facts
        RequestContextHolder.currentRequestAttributes().renderView = false

    }

    def edit() {
        def chmHolderInstance = OpticalStructureRecognition.get(params.id)
        if (!chmHolderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'chmHolder.label', default: 'OpticalStructureRecognition'), params.id])
            redirect(action: "list")
            return
        }

        [chmHolderInstance: chmHolderInstance]
    }

    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def update() {
        def chmHolderInstance = OpticalStructureRecognition.get(params.id)
        if (!chmHolderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'chmHolder.label', default: 'OpticalStructureRecognition'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (chmHolderInstance.version > version) {
                chmHolderInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'chmHolder.label', default: 'OpticalStructureRecognition')] as Object[],
                          "Another user has updated this OpticalStructureRecognition while you were editing")
                render(view: "edit", model: [chmHolderInstance: chmHolderInstance])
                return
            }
        }

        chmHolderInstance.properties = params

        if (!chmHolderInstance.save(flush: true)) {
            render(view: "edit", model: [chmHolderInstance: chmHolderInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'chmHolder.label', default: 'OpticalStructureRecognition'), chmHolderInstance.id])
        redirect(action: "show", id: chmHolderInstance.id)
    }

    def delete() {
        def chmHolderInstance = OpticalStructureRecognition.get(params.id)
        if (!chmHolderInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'chmHolder.label', default: 'OpticalStructureRecognition'), params.id])
            redirect(action: "list")
            return
        }

        try {
            chmHolderInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'chmHolder.label', default: 'OpticalStructureRecognition'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'chmHolder.label', default: 'OpticalStructureRecognition'), params.id])
            redirect(action: "show", id: params.id)
        }
    }




    def listMols() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
         def result="cmd /c osra.bat \\temp\\downloaded.png".execute().text
        [chmHolderInstanceList: OpticalStructureRecognition.list(params), chmHolderInstanceTotal: OpticalStructureRecognition.count()]
    }

    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def saveOsra() {
        String nameOfTemporaryFile =  "c:/temp/dnld${currentUser()}.png"
        if ( request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
            def downloadedFile  =  multipartHttpServletRequest.getFile("payload")
            downloadedFile.transferTo new File(nameOfTemporaryFile)
            flash.weveBeenHereBefore = 'true'
        }
        redirect(action: "list", params: params)
    }


    private boolean somebodyIsLoggedIn () {
        (!"anonymousUser".equals (springSecurityService?.principal))
    }

    private currentUser () {
        String nameOfCurrentUser =   springSecurityService?.principal?.id
        TbUser tbUser = TbUser.get(nameOfCurrentUser)
        return tbUser.username.trim()
    }

}
