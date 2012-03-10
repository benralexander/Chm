package fam

import grails.test.mixin.*
import javax.servlet.http.HttpServletResponse

@TestFor(OpticalStructureRecognitionController)
@Mock(OpticalStructureRecognition)
class OpticalStructureRecognitionControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/chmHolder/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.chmHolderInstanceList.size() == 0
        assert model.chmHolderInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.chmHolderInstance != null
    }

    void testSave() {
        controller.save()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.save()

        assert model.chmHolderInstance != null
        assert view == '/chmHolder/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/chmHolder/show/1'
        assert controller.flash.message != null
        assert OpticalStructureRecognition.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/chmHolder/list'


        populateValidParams(params)
        def chmHolder = new OpticalStructureRecognition(params)

        assert chmHolder.save() != null

        params.id = chmHolder.id

        def model = controller.show()

        assert model.chmHolderInstance == chmHolder
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/chmHolder/list'


        populateValidParams(params)
        def chmHolder = new OpticalStructureRecognition(params)

        assert chmHolder.save() != null

        params.id = chmHolder.id

        def model = controller.edit()

        assert model.chmHolderInstance == chmHolder
    }

    void testUpdate() {

        controller.update()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/chmHolder/list'

        response.reset()


        populateValidParams(params)
        def chmHolder = new OpticalStructureRecognition(params)

        assert chmHolder.save() != null

        // test invalid parameters in update
        params.id = chmHolder.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/chmHolder/edit"
        assert model.chmHolderInstance != null

        chmHolder.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/chmHolder/show/$chmHolder.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        chmHolder.clearErrors()

        populateValidParams(params)
        params.id = chmHolder.id
        params.version = -1
        controller.update()

        assert view == "/chmHolder/edit"
        assert model.chmHolderInstance != null
        assert model.chmHolderInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/chmHolder/list'

        response.reset()

        populateValidParams(params)
        def chmHolder = new OpticalStructureRecognition(params)

        assert chmHolder.save() != null
        assert OpticalStructureRecognition.count() == 1

        params.id = chmHolder.id

        controller.delete()

        assert OpticalStructureRecognition.count() == 0
        assert OpticalStructureRecognition.get(chmHolder.id) == null
        assert response.redirectedUrl == '/chmHolder/list'
    }
}
