package fam



import org.junit.*
import grails.test.mixin.*
import javax.servlet.http.HttpServletResponse

@TestFor(BuildCombinatorialLibraryController)
@Mock(BuildCombinatorialLibrary)
class BuildCombinatorialLibraryControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/buildCombinatorialLibrary/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.buildCombinatorialLibraryInstanceList.size() == 0
        assert model.buildCombinatorialLibraryInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.buildCombinatorialLibraryInstance != null
    }

    void testSave() {
        controller.save()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.save()

        assert model.buildCombinatorialLibraryInstance != null
        assert view == '/buildCombinatorialLibrary/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/buildCombinatorialLibrary/show/1'
        assert controller.flash.message != null
        assert BuildCombinatorialLibrary.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/buildCombinatorialLibrary/list'


        populateValidParams(params)
        def buildCombinatorialLibrary = new BuildCombinatorialLibrary(params)

        assert buildCombinatorialLibrary.save() != null

        params.id = buildCombinatorialLibrary.id

        def model = controller.show()

        assert model.buildCombinatorialLibraryInstance == buildCombinatorialLibrary
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/buildCombinatorialLibrary/list'


        populateValidParams(params)
        def buildCombinatorialLibrary = new BuildCombinatorialLibrary(params)

        assert buildCombinatorialLibrary.save() != null

        params.id = buildCombinatorialLibrary.id

        def model = controller.edit()

        assert model.buildCombinatorialLibraryInstance == buildCombinatorialLibrary
    }

    void testUpdate() {

        controller.update()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/buildCombinatorialLibrary/list'

        response.reset()


        populateValidParams(params)
        def buildCombinatorialLibrary = new BuildCombinatorialLibrary(params)

        assert buildCombinatorialLibrary.save() != null

        // test invalid parameters in update
        params.id = buildCombinatorialLibrary.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/buildCombinatorialLibrary/edit"
        assert model.buildCombinatorialLibraryInstance != null

        buildCombinatorialLibrary.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/buildCombinatorialLibrary/show/$buildCombinatorialLibrary.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        buildCombinatorialLibrary.clearErrors()

        populateValidParams(params)
        params.id = buildCombinatorialLibrary.id
        params.version = -1
        controller.update()

        assert view == "/buildCombinatorialLibrary/edit"
        assert model.buildCombinatorialLibraryInstance != null
        assert model.buildCombinatorialLibraryInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/buildCombinatorialLibrary/list'

        response.reset()

        populateValidParams(params)
        def buildCombinatorialLibrary = new BuildCombinatorialLibrary(params)

        assert buildCombinatorialLibrary.save() != null
        assert BuildCombinatorialLibrary.count() == 1

        params.id = buildCombinatorialLibrary.id

        controller.delete()

        assert BuildCombinatorialLibrary.count() == 0
        assert BuildCombinatorialLibrary.get(buildCombinatorialLibrary.id) == null
        assert response.redirectedUrl == '/buildCombinatorialLibrary/list'
    }
}
