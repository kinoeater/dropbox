describe('Search a word in google',() => {

    it('Navigate to google ', () => {
        cy.visit('https://www.google.com/')
        
       

    })


    it('contains "Google" in the title', () => {

        cy.title().should('contain', 'Google');
        cy.log('Successfully landed on google')
    });

    it('Search for a word', () => {
          
     
        cy.get('.gLFyf').type('Hello, Google {enter}')
        cy.log('Successfully searched the word')

      
})
