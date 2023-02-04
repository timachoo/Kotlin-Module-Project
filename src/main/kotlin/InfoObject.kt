open class InfoObject (
    val name : String
){
    companion object {
        fun checkName(name: String?): Boolean {
            return !name?.trim().isNullOrEmpty()
        }
    }
}