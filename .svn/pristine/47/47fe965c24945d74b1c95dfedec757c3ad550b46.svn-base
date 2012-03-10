package fam



import org.junit.*
import grails.test.mixin.*
import javax.servlet.http.HttpServletResponse

@TestFor(PrincipalMomentOfInertiaPlotController)
@Mock(PrincipalMomentOfInertiaPlot)
class PrincipalMomentOfInertiaPlotControllerTests {


    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/principalMomentOfInertiaPlot/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.principalMomentOfInertiaPlotInstanceList.size() == 0
        assert model.principalMomentOfInertiaPlotInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.principalMomentOfInertiaPlotInstance != null
    }

    void testSave() {
        controller.save()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.save()

        assert model.principalMomentOfInertiaPlotInstance != null
        assert view == '/principalMomentOfInertiaPlot/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/principalMomentOfInertiaPlot/show/1'
        assert controller.flash.message != null
        assert PrincipalMomentOfInertiaPlot.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/principalMomentOfInertiaPlot/list'


        populateValidParams(params)
        def principalMomentOfInertiaPlot = new PrincipalMomentOfInertiaPlot(params)

        assert principalMomentOfInertiaPlot.save() != null

        params.id = principalMomentOfInertiaPlot.id

        def model = controller.show()

        assert model.principalMomentOfInertiaPlotInstance == principalMomentOfInertiaPlot
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/principalMomentOfInertiaPlot/list'


        populateValidParams(params)
        def principalMomentOfInertiaPlot = new PrincipalMomentOfInertiaPlot(params)

        assert principalMomentOfInertiaPlot.save() != null

        params.id = principalMomentOfInertiaPlot.id

        def model = controller.edit()

        assert model.principalMomentOfInertiaPlotInstance == principalMomentOfInertiaPlot
    }

    void testUpdate() {

        controller.update()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/principalMomentOfInertiaPlot/list'

        response.reset()


        populateValidParams(params)
        def principalMomentOfInertiaPlot = new PrincipalMomentOfInertiaPlot(params)

        assert principalMomentOfInertiaPlot.save() != null

        // test invalid parameters in update
        params.id = principalMomentOfInertiaPlot.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/principalMomentOfInertiaPlot/edit"
        assert model.principalMomentOfInertiaPlotInstance != null

        principalMomentOfInertiaPlot.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/principalMomentOfInertiaPlot/show/$principalMomentOfInertiaPlot.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        principalMomentOfInertiaPlot.clearErrors()

        populateValidParams(params)
        params.id = principalMomentOfInertiaPlot.id
        params.version = -1
        controller.update()

        assert view == "/principalMomentOfInertiaPlot/edit"
        assert model.principalMomentOfInertiaPlotInstance != null
        assert model.principalMomentOfInertiaPlotInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/principalMomentOfInertiaPlot/list'

        response.reset()

        populateValidParams(params)
        def principalMomentOfInertiaPlot = new PrincipalMomentOfInertiaPlot(params)

        assert principalMomentOfInertiaPlot.save() != null
        assert PrincipalMomentOfInertiaPlot.count() == 1

        params.id = principalMomentOfInertiaPlot.id

        controller.delete()

        assert PrincipalMomentOfInertiaPlot.count() == 0
        assert PrincipalMomentOfInertiaPlot.get(principalMomentOfInertiaPlot.id) == null
        assert response.redirectedUrl == '/principalMomentOfInertiaPlot/list'
    }
}
