


kaboom({
    global:true,
    fullscreen: true,
    font: "sinko",
    canvas: document.querySelector("#mycanvas"),
    background:[0,0,255],
    scale:1,
    debug: true,
    // clearColor:[1,1,1,0],
})

// Speeds
const MOVE_SPEED = 120
const SLICER_SPEED = 100
const SKELETOR_SPEED = 60


// TEXTURES // SPRITES

// loading root of textures
loadRoot('https://i.imgur.com/')

loadSprite('link-going-left', 'eiY5zyX.png')
loadSprite('link-going-right', 'yZIb8O2.png')
loadSprite('link-going-down', 'r377FIM.png')
loadSprite('link-going-up', 'UkV0we0.png')

loadSprite('leftWall', 'rfDoaa1.png')
loadSprite('rightWall', 'SmHhgUn.png')
loadSprite('topWall', 'QA257Bj.png')
loadSprite('bottomWall', 'vWJWmvb.png')

loadSprite('bottomleftWall', 'awnTfNC.png')
loadSprite('bottomRightWall', '84oyTFy.png')
loadSprite('top-rightWall', 'z0OmBd1.jpeg')
loadSprite('top-leftWall', 'xlpUxIm.png')

loadSprite('top-door','U9nre4n.png')
loadSprite('left-door','okdJNls.png')
loadSprite('fire-pot','I7xSp7w.png')
loadSprite('lanterns','wiSiY09.png')
loadSprite('slicer','c6JFi5Z.png')
loadSprite('skeletor','Ei1VnX8.png')
loadSprite('stairs','hokdJNls.png')
loadSprite('bg','u4DVsx6.png')
loadSprite('kaboom','o9WizfI.png')


scene("game", ({level, score}) => {

    layers(['bg', 'obj', 'ui'], 'obj')

    const map = [
        'zcccccc#cccx',
        'a          b',
        'a       *  b',
        '%    >     b',
        'a          b',
        'a    >     b',
        'a          b',
        'a   *      b',
        'wdd{ddd{dddy'
    ]

    const levelCfg = {
        width:48,
        height:48,
        'a': [sprite('leftWall'),solid()],
        'b': [sprite('rightWall'),solid()],
        'c': [sprite('topWall'),solid()],
        'd': [sprite('bottomWall'),solid()],

        'w': [sprite('bottomleftWall'),solid()],
        'x': [sprite('top-rightWall'),solid()],
        'y': [sprite('bottomRightWall'),solid()],
        'z': [sprite('top-leftWall'),solid()],

        '%': [sprite('left-door')],
        '#': [sprite('top-door')],
        '^': [sprite('stairs')],

        '*': [sprite('slicer')],
        '}': [sprite('skeletor')],
        '{': [sprite('lanterns'),solid()],
        '>': [sprite('fire-pot'),solid()],
    }
    addLevel(map,levelCfg)


    // BACKGROUND
    // add(sprite('bg'), layer('bg'))

    add([
        text('0'),
        pos(400,450),
        layer('ui'),
        {
            value: score,
        },
        scale(2)
    ])


    add([text('Towers of Hanoi' +
        parseInt(level + 1)),
        pos(400,485),
        scale(2)])

    // player

    const player = add([
        sprite('link-going-right'),
        pos(5,190),
        {
            dir: vec2(1,0)
        }
    ])

    player.action(() => {
        player.resolve()
    })

    keyDown('left', () => {
        player.changeSprite('link-going-left')
        player.move(-MOVE_SPEED,0)
        player.dir = vec2(-1,0)
    })
    keyDown('right', () => {
        player.changeSprite('link-going-right')
        player.move(MOVE_SPEED,0)
        player.dir = vec2(1,0)
    })
    keyDown('up', () => {
        player.changeSprite('link-going-up')
        player.move(0, -MOVE_SPEED)
        player.dir = vec2(0,-1)
    })
    keyDown('down', () => {
        player.changeSprite('link-going-down')
        player.move(0, MOVE_SPEED)
        player.dir = vec2(0,1)
    })
})

start("game", {level:0,score:0,health:10})
