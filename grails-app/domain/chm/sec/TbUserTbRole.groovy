package chm.sec

import org.apache.commons.lang.builder.HashCodeBuilder

class TbUserTbRole implements Serializable {

    TbUser tbUser
    TbRole tbRole

    boolean equals(other) {
        if (!(other instanceof TbUserTbRole)) {
            return false
        }

        other.tbUser?.id == tbUser?.id &&
                other.tbRole?.id == tbRole?.id
    }

    int hashCode() {
        def builder = new HashCodeBuilder()
        if (tbUser) builder.append(tbUser.id)
        if (tbRole) builder.append(tbRole.id)
        builder.toHashCode()
    }

    static TbUserTbRole get(long tbUserId, long tbRoleId) {
        find 'from TbUserTbRole where tbUser.id=:tbUserId and tbRole.id=:tbRoleId',
                [tbUserId: tbUserId, tbRoleId: tbRoleId]
    }

    static TbUserTbRole create(TbUser tbUser, TbRole tbRole, boolean flush = false) {
        new TbUserTbRole(tbUser: tbUser, tbRole: tbRole).save(flush: flush, insert: true)
    }

    static boolean remove(TbUser tbUser, TbRole tbRole, boolean flush = false) {
        TbUserTbRole instance = TbUserTbRole.findByTbUserAndTbRole(tbUser, tbRole)
        if (!instance) {
            return false
        }

        instance.delete(flush: flush)
        true
    }

    static void removeAll(TbUser tbUser) {
        executeUpdate 'DELETE FROM TbUserTbRole WHERE tbUser=:tbUser', [tbUser: tbUser]
    }

    static void removeAll(TbRole tbRole) {
        executeUpdate 'DELETE FROM TbUserTbRole WHERE tbRole=:tbRole', [tbRole: tbRole]
    }

    static mapping = {
        id composite: ['tbRole', 'tbUser']
        version false
    }
}
