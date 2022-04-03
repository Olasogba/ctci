// Insert(value), find(value), findMin() ,findMax(), and contains(), DFS(), BFS(), DFSInOrder(), DFSPreOrder(), DFSPostOrder()

class BSTNode {
    left;
    right
    value
    constructor(value) {
        this.value = value;
    }

    insert(value, root) {
        var node = new BSTNode(value)
        if(root.value<value) {
            if(root.right) {
                this.insert(value, root.right)
            } else {
                root.right = node;
            }
        } else {
            if(root.left) {
                this.insert(value, root.left)
            } else {
                root.left = node;
            }
        }
    }


    bfs() {
        var queue = []
        var store = []
        queue.push(this)
        while(queue.length) {
            var node = queue.pop()
            store.push(node.value)
            if(node.left) {
                queue.push(node.left)
            }
            if(node.right) {
                queue.push(node.right)
            }
        }
        return store;
    }

    dfsPreOrder(root, store) {
        store.push(root.value)
        if(root.left) {
            this.dfsPreOrder(root.left, store)
        }
        if(root.right) {
            this.dfsPreOrder(root.right, store)
        }
        return store
    }

    dfsInOrder(root, store) {
        if(root.left) {
            this.dfsInOrder(root.left, store)
        }
        store.push(root.value)
        if(root.right) {
            this.dfsInOrder(root.right, store)
        }
        return store
    }

    dfsPostOrder(root, store) {
        if(root.left) {
            this.dfsPostOrder(root.left, store)
        }
        if(root.right) {
            this.dfsPostOrder(root.right, store)
        }
        store.push(root.value)
        return store
    }

    findMin() {
        return Math.min(...this.bfs())
    }


    findMax() {
        return Math.max(...this.bfs())
    }

    contains(value) {
        return this.bfs().includes(value)
    }
}

var n = new BSTNode(1)
n.insert(2, n)
n.insert(3, n)
n.insert(0, n)
n.insert(5, n)
n.insert(4, n)
n.insert(6, n)
n.insert(-1, n)
n.insert(-2, n)

// console.log(n);
console.log(n.bfs())
// console.log(n.dfsPreOrder(n, []))
// console.log(n.dfsInOrder(n, []))
// console.log(n.dfsPostOrder(n, []))
// console.log(n.findMax());
// console.log(n.findMin());
// console.log(n.contains(2))