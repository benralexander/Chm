package fam

class MolHolder {
    String smiles
    static constraints = {
        smiles(blank: false)
    }
}
