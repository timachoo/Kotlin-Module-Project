class Note (
    name : String,
    val text : String
) : InfoObject(name)
{
    override fun toString() : String {
        return this.name
    }
}