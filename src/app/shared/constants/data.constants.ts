///////////////////////////////////////////////////////////////////////////////////////////////
// Various data points to be used in the app
///////////////////////////////////////////////////////////////////////////////////////////////

export class DataConstants {
    public static apiKey = '6135f78e52c9e3ca';
    public static api = 'https://api.wunderground.com/api/'+DataConstants.apiKey+'/conditions/q';
    public static cities = [
    	{
    		'state': 'CA',
    		'name' : 'san_jose'
    	},
    	{
    		'state': 'TX',
    		'name' : 'austin'
    	},
    	{
    		'state': 'DC',
    		'name' : 'washington'
    	},
    	{
    		'state': 'CO',
    		'name' : 'denver'
    	},
    	{
    		'state': 'AR',
    		'name' : 'fayetteville'
    	},
    	{
    		'state': 'WA',
    		'name' : 'seattle'
    	},
    	{
    		'state': 'NC',
    		'name' : 'raleigh'
    	},
    	{
    		'state': 'MA',
    		'name' : 'boston'
    	},
    	{
    		'state': 'IA',
    		'name' : 'des_moines'
    	},
    	{
    		'state': 'UT',
    		'name' : 'salt_lake_city'
    	}
    ];
    
}