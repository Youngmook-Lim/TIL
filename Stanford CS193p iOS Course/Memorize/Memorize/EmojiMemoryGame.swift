//
//  EmojiMemoryGame.swift
//  Memorize
//
//  Created by Youngmook Lim on 1/15/25.
//

import SwiftUI

class EmojiMemoryGame {
    static let emojis = ["👻", "🎃", "🕷️", "😈", "💀", "🕸️", "🧙‍♀️", "🙀", "👹", "😱", "☠️", "🍭"]
    
    private var model = MemoryGame(numberOfPairsOfCards: 4) { pairIndex in
        return emojis[pairIndex]
    }
    
    
    var cards: Array<MemoryGame<String>.Card> {
        return model.cards
    }
    
    func choose(_ card: MemoryGame<String>.Card) {
        model.choose(card)
    }
}
