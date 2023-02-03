class Archive(
    name : String
) : InfoObject(name) {
    val notes = mutableListOf<Note>()

    fun addNote(name :String, text : String){
        notes.add(Note(name, text))
    }

    override fun toString() : String {
        return name
    }
}


