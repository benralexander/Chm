import grails.util.GrailsUtil
import chm.sec.TbRole
import org.springframework.security.core.userdetails.User
import chm.sec.TbUser
import chm.sec.TbUserTbRole
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.context.HttpSessionSecurityContextRepository
import org.apache.commons.logging.LogFactory

class BootStrap {
    def springSecurityService

    //private static def log = LogFactory.getLog(this)
    def init = { servletContext ->

        switch (GrailsUtil.environment) {
            case "laptop":
            case "test":
            case "development":
                break;
            case "production":
                break;
        }


        def samples = [
                'ben': [fullName: 'ben', password: "a", email: "hhh@ggg.com"],
                'a': [fullName: 'a', password: "a", email: "hhh@ggg.com"],
                'b': [fullName: 'b', password: "a", email: "hhh@ggg.com"]
        ]

        def userRole = TbRole.findByAuthority("ROLE_USER") ?: new TbRole(authority: "ROLE_USER").save(flush: true)
        def adminRole = TbRole.findByAuthority("ROLE_ADMIN") ?: new TbRole(authority: "ROLE_ADMIN").save(flush: true)
        def users = TbUser.list() ?: []

        //  we need to make users from scratch
        if (!users) {

            samples.each {username, profileAttributes ->

                chm.sec.TbUser tbUser = new chm.sec.TbUser(
                        username: username,
                        password: profileAttributes.password,
                        enabled: true)

                if (tbUser.validate()) {

                    tbUser.save(flush: true)
                    if ((tbUser.authorities.contains(adminRole)) ||
                            (tbUser.username=='ben')){
                        println "user ${username} was admin\n"
                        TbUserTbRole.create tbUser, adminRole, true
                    } else {
                        println "user ${username} was no admin\n"
                        TbUserTbRole.create tbUser, userRole, true
                    }

                } else {
                    println "failed to creating user ${username}…"

                }

                users << tbUser
            }
        }


    }
    def destroy = {
    }
}
