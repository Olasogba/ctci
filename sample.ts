class Trie {
    root: TrieNode
    constructor() {
        this.root = new TrieNode('')
    }

    insert(word: string) { // act
        word = word.toLocaleLowerCase()
        var current = this.root
        for(var x of word) { // a
            var index = x.charCodeAt(0) - 'a'.charCodeAt(0)
            if(current.children[index]) {
                current = current.children[index]
            } else {
                var newNode = new TrieNode(x)
                current.children[index] = newNode
                current = current.children[index]
            }
        }
        current.isEnd = true
    }

    contains(word: string): boolean { // Act, Ab
        word = word.toLocaleLowerCase()
        var current = this.root
        for(var x of word) {
            var index = x.charCodeAt(0) - 'a'.charCodeAt(0)
            if(!current.children[index]) return false
            current = current.children[index]
        }

        return current.isEnd
    }
}


class TrieNode {
    children: TrieNode[]
    isEnd: boolean
    value: string


    constructor(value: string) {
        this.children = []
        this.value = value
        this.isEnd = false
    }
}

var t = new Trie()

t.insert('Able')
t.insert('Interdenominationalism')

console.log(t.contains('Interdenominationalis'))
console.log(t)