package fam

import org.springframework.web.multipart.MultipartFile

class OpticalStructureRecognition {

    static hasMany = [molHolderList: MolHolder]

   // MultipartFile multipartFile
    def multipartFile
    List<MolHolder>  molHolderList
    static constraints = {
        multipartFile(nullable: true)
        molHolderList()
    }
}
