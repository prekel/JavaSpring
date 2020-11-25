using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

using Frankenstein.AspNet.Models;

using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.ChangeTracking;
using Microsoft.Extensions.Logging;

namespace Frankenstein.AspNet.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class AddController
    {
        private readonly ILogger<ViewController> _logger;
        private readonly FurnitureContext _context;

        public AddController(ILogger<ViewController> logger, FurnitureContext context)
        {
            _logger = logger;
            _context = context;
        }
        
        [HttpPost("/")]
        public async Task Add(Furniture furniture)
        {
            await _context.Furnitures.AddAsync(furniture);
            await _context.SaveChangesAsync();
        }
    }
}
